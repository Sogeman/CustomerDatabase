import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Customer {
  id: number;
  firstName: string;
  lastName: string;
  birthDate: string;
  activated: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  customer: Customer;

  constructor(private httpClient: HttpClient) { }

  create(customer: Customer) {
    this.httpClient.post().toPromise();
  }
}
