import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Item } from '../models/item.model';
import { Cart } from '../models/cart.model';
import { Order } from '../models/order.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public cartAddedSubject = new Subject<boolean>();

  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<Item[]> {
    return this.http.get<Item[]>("http://localhost:8090/scrum/items/");
  }

  addToCart(productId: number, quantity: number, username: string) : Observable<any> {
    const params = new HttpParams()
      .set ('id',  productId)
      .set ('quantity', quantity)
      .set ('client', username)
    ;
    return this.http.post<any>("http://localhost:8090/scrum/cart/addItemCart",params);
  }

  getCartByUsername(username: string) : Observable<Cart>  {
    return this.http.get<Cart>("http://localhost:8090/scrum/cart/getCartByUsername?username=" + username);
  }
  removeCartItemById(itemId: number, username: string) : Observable<any[]>  {
    return this.http.delete<any[]>("http://localhost:8090/scrum/cart/removeItem?itemId=" + itemId + "&client=" + username);
  }

  sentOrder(username: string) : Observable<any> {
    const params = new HttpParams()
    .set ('username',  username)
    return this.http.post<any>("http://localhost:8090/scrum/orders/addOrder",params);
  }

  getOrdersByUserId(userId: number): Observable<Order[]> {
    return this.http.get<Order[]>('http://localhost:8090/scrum/orders/' + userId);
  }
}
