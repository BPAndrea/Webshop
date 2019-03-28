import { Injectable } from '@angular/core';

import { ProductOrder } from '../models/ProductOrder';

import { ProductOrders } from '../models/ProductOrders';

import { Subject } from 'rxjs';

import { HttpClient } from 'selenium-webdriver/http';

@Injectable()
export class EcommerceService {
    private productsUrl = "/api/products";
    private ordersUrl = "/api/orders";
 
    private productOrder: ProductOrder;
    private orders: ProductOrders = new ProductOrders();
 
    private productOrderSubject = new Subject();
    private ordersSubject = new Subject();
    private totalSubject = new Subject();
 
    private total: number;
 
    ProductOrderChanged = this.productOrderSubject.asObservable();
    OrdersChanged = this.ordersSubject.asObservable();
    TotalChanged = this.totalSubject.asObservable();
 
    constructor(private http: HttpClient) {
    }
 
    getAllProducts() {
        return this.http.get(this.productsUrl);
    }
 
    saveOrder(order: ProductOrders) {
        return this.http.post(this.ordersUrl, order);
    }
 
    // getters and setters for shared fields
}