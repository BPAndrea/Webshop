import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { WebshopComponent } from './webshop/webshop.component';
import { BooksComponent } from './webshop/books/books.component';
import { OrdersComponent } from './webshop/orders/orders.component';
import { ShoppingCartComponent } from './webshop/shopping-cart/shopping-cart.component';

@NgModule({
  declarations: [
    AppComponent,
    WebshopComponent,
    BooksComponent,
    OrdersComponent,
    ShoppingCartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
