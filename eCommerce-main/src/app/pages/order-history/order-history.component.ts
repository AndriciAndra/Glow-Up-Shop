import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit {

  orders: Order[] = []

  constructor(private readonly productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getOrdersByUserId(1).subscribe(
      (data: Order[]) =>{
        this.orders = data;
      } 
    )
  }
}
