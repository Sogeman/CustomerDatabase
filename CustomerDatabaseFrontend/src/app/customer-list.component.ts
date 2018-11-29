import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CustomerService, Customer } from './customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  @Output() add = new EventEmitter();
  @Output() edit = new EventEmitter<number>();
  customerList: Customer[];
  checkmark: string;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.refresh();
  }

  refresh() {
    this.customerService.retrieveAll()
      .then(customerList => this.customerList = customerList);
  }

  addCustomer() {
    this.add.emit();
  }

  editCustomer(customer: Customer) {
    this.edit.emit(customer.id);
  }

  deleteCustomer(customer: Customer) {
    if (confirm('Wirklich löschen?')) {
      this.customerService.delete(customer.id)
        .then(() => this.refresh());
    }
  }

}
