import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/models/item.model';
import { ProductService } from 'src/app/services/product.service';
import {
  MatSnackBar
} from '@angular/material/snack-bar';
import { TotalItemsService } from 'src/app/services/totalItems.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  productList: Item [] = [];
  
  constructor(private productService: ProductService,
    private _snackBar: MatSnackBar,
    private totalItemsService: TotalItemsService) {

  }
  ngOnInit(): void {
    this.loadAllProducts();
  }

  loadAllProducts() {
    this.productService.getAllProducts().subscribe((result: Item[]) => {
      this.productList = result.map(item => ({
        ...item,
        photo: this.decodeBase64Photo(item.photo)
      }));
    });
  }

  decodeBase64Photo(base64String: string): string {
    return 'data:image/jpeg;base64,' + base64String;
  }

  addItemToCart(productId: number) {
    this.productService.addToCart(productId, 1, "Andreea").subscribe();
    this._snackBar.open("Item added to the cart!", "X", {duration: 5000});
    this.totalItemsService.updateNumber(1);
  }
}
