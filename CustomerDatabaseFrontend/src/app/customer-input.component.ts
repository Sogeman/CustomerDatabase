import { Component, Output, EventEmitter } from '@angular/core';
import { Customer, CustomerService } from './customer.service';

@Component({
  selector: 'app-customer-input',
  templateUrl: './customer-input.component.html',
  styleUrls: ['./customer-input.component.css']
})
export class CustomerInputComponent {

  @Output() ok = new EventEmitter<Customer>(); // specific emit not necessary?
  customer: Customer;
  today: number =  Date.now();

  constructor(private customerService: CustomerService) { }

  startAdding() {
    this.customer = new Customer();
  }

  startEditing(id: number) {
    this.customerService.retrieve(id)
      .then(customer => this.customer = customer);
  }

  clickedOkay() {
    this.createOrUpdate()
      .then(() => {
        this.ok.emit(this.customer);
        this.customer = null;
      });
  }

  createOrUpdate(): Promise<any> {
    if (this.customer.id) {
      return this.customerService.update(this.customer);
    } else {
      return this.customerService.create(this.customer);
    }
  }

  clearCustomer() {
    // emit not necessary in this case
    this.customer = null;
  }

}
