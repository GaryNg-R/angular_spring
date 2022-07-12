import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderHistory } from '../common/order-history';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class OrderHistoryService {
  private orderUrl = environment.luv2shopApiUrl + '/orders';
  constructor(private httpClient: HttpClient) {}

  getOrderHistory(theEmail: string): Observable<GetResponseOrderHistory> {
    //need to build URL base on customer email
    const orderHistoryUrl = `${this.orderUrl}/search/by-customer-email?email=${theEmail}&sort=dateCreated,DESC`;

    return this.httpClient.get<GetResponseOrderHistory>(orderHistoryUrl);
  }
}

interface GetResponseOrderHistory {
  //Unwraps the JSON from Spring Data Rest _embedded entry
  _embedded: {
    orders: OrderHistory[];
  };
}
