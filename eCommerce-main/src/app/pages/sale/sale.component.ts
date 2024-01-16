import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cart } from 'src/app/models/cart.model';
import { CartItem } from 'src/app/models/cartItem.model';
import { Item } from 'src/app/models/item.model';
import { ProductService } from 'src/app/services/product.service';
import { TotalItemsService } from 'src/app/services/totalItems.service';
import { UpdateCartService } from 'src/app/services/update-cart.service';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {
  cart: Cart | undefined;
  
  constructor(private productService: ProductService,
    private _snackBar: MatSnackBar,
    private updateCartService: UpdateCartService,
    private totalItemsService: TotalItemsService) {
  }
  ngOnInit(): void {
    this.loadCart();
    this.updateCartService.item$.subscribe(() => {
      this.loadCart();
    })
  }

  loadCart() {
    this.productService.getCartByUsername('Andreea').subscribe((res: Cart) => {
      this.cart = res;
    })
  }
  RemoveItem(cartItem: CartItem) {
    this.productService.removeCartItemById(cartItem.item.id, 'Andreea').subscribe(() => { });
    this._snackBar.open("Item removed!", "X", {duration: 5000});

    this.cart?.cartItems.splice(this.cart.cartItems.indexOf(cartItem), 1)
    this.totalItemsService.updateNumber(-1);
  }
  SentOrder() {
    this.productService.sentOrder('Andreea').subscribe();
    this._snackBar.open("Thank you for your order!", "X", {duration: 5000});
  }
}
