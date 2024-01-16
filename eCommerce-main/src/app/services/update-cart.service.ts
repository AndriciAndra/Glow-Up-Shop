import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UpdateCartService {
  private cart: BehaviorSubject<number> = new BehaviorSubject<number>(1);
  public item$: Observable<number> = this.cart.asObservable();

  updateCart(update: number): void {
    this.cart.next(update);
  }
}