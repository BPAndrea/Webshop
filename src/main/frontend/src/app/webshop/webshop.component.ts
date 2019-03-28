import { Component, OnInit, ViewChild } from '@angular/core';
import { BooksComponent } from './books/books.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { OrdersComponent } from './orders/orders.component';

@Component({
  selector: 'app-webshop',
  templateUrl: './webshop.component.html',
  styleUrls: ['./webshop.component.css']
})
export class WebshopComponent implements OnInit {
  booksC: any;

  /*constructor() { }*/

  ngOnInit() {
  }

  private collapsed = true;
  orderFinished = false;

  @ViewChild('booksC')
  productsC: BooksComponent;

  @ViewChild('shoppingCartC')
  shoppingCartC: ShoppingCartComponent;

  @ViewChild('ordersC')
  ordersC: OrdersComponent;

  toggleCollapsed(): void {
      this.collapsed = !this.collapsed;
  }

  finishOrder(orderFinished: boolean) {
      this.orderFinished = orderFinished;
  }

  reset() {
      this.orderFinished = false;
      this.booksC.reset();
      this.shoppingCartC.reset();
      this.ordersC.paid = false;
  }
}
