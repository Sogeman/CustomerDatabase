import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Customer {
  id: number;
  firstName: string;
  lastName: string;
  birthDate: string;
  activated = false;
}

const CUSTOMER_RESOURCE_URL = 'http://localhost:8080/customers/resources/customers';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  customer: Customer;

  constructor(private httpClient: HttpClient) { }

  create(customer: Customer): Promise<any> {
    return this.httpClient.post(CUSTOMER_RESOURCE_URL, customer).toPromise();
  }

  retrieve(id: number): Promise<Customer> {
    return this.httpClient.get<Customer>(CUSTOMER_RESOURCE_URL + '/' + id).toPromise();
  }

  retrieveAll(): Promise<Customer[]> {
    return this.httpClient.get<Customer[]>(CUSTOMER_RESOURCE_URL).toPromise();
  }

  retrieveAllFiltered(activatedFilter: boolean): Promise<Customer[]> {
    return this.httpClient.get<Customer[]>(
      CUSTOMER_RESOURCE_URL + '/activated/' + activatedFilter)
      .toPromise();
  }

  update(customer: Customer): Promise<any> {
    return this.httpClient.put(CUSTOMER_RESOURCE_URL + '/' + customer.id, customer).toPromise();
  }

  delete(id: number): Promise<any> {
    return this.httpClient.delete(CUSTOMER_RESOURCE_URL + '/' + id).toPromise();
  }

}
