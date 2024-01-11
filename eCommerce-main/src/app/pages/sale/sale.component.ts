import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cart } from 'src/app/models/cart.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {
  cart: Cart | undefined;
  
  constructor(private productService: ProductService, private _snackBar: MatSnackBar) {
  }
  ngOnInit(): void {
    this.loadCart();
  }

  loadCart() {
    this.productService.getCartByUsername('Andreea').subscribe((res: Cart) => {
      this.cart = res;
    })
  }
  RemoveItem(id: number) {
    this.productService.removeCartItemById(id, 'Andreea').subscribe();
    this._snackBar.open("Item removed!", "X", {duration: 5000});
  }
}
