import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TotalItemsService {
  private totalItems: BehaviorSubject<number> = new BehaviorSubject<number>(0);
  public number$: Observable<number> = this.totalItems.asObservable();

  updateNumber(newNumber: number): void {
    this.totalItems.next(newNumber);
  }
}