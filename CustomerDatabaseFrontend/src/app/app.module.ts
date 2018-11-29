import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list.component';
import { CustomerInputComponent } from './customer-input.component';
import { CustomerComponent } from './customer.component';
import { HttpClientModule } from '@angular/common/http';
import { FilterComponent } from './filter.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CustomerInputComponent,
    CustomerComponent,
    FilterComponent,
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
