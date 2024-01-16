import { Component, OnInit } from '@angular/core';
import { ProductService } from './services/product.service';
import { Router } from '@angular/router';
import { Cart } from './models/cart.model';
import { TotalItemsService } from './services/totalItems.service';
import { UpdateCartService } from './services/update-cart.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ecommerce';
  cart: Cart | undefined;
  totalItems: number = 0;

  constructor(private productService: ProductService,
    private router: Router,
    private totalItemsService: TotalItemsService) { }

  ngOnInit(): void {
    this.loadCart();
    this.totalItemsService.number$.subscribe((number) => {
      this.totalItems += number;
    });
  }

  redirectToSale() {
    this.router.navigateByUrl("/sale");
  }

  redirectToOrderHistory() {
    this.router.navigateByUrl("/orderHistory")
  }

  loadCart() {
    this.productService.getCartByUsername('Andreea').subscribe((res: Cart)=> {
      this.cart = res;
      this.totalItems = res.totalItems;
    })
  }
}
