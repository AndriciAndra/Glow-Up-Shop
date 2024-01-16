import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { SaleComponent } from './pages/sale/sale.component';
import { OrderHistoryComponent } from './pages/order-history/order-history.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: 'products',
    component: HomeComponent
  },
  {
    path: 'sale',
    component: SaleComponent
  },
  {
    path: 'orderHistory',
    component: OrderHistoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
