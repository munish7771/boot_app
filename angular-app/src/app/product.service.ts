import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  baseUrl='http://localhost:8081/products'
  constructor(public http:HttpClient) { }
  // no idea about them
  private productSource = new BehaviorSubject('list');
  currentProductList = this.productSource.asObservable();

  listAllProduct() {
    return this.http.get(this.baseUrl+'/');
  }

  addProduct(name, category, description) {
    const product = {
      name: name,
      category: category,
      description: description
    };
    return this.http.post(`${this.baseUrl}/`, product);
  }

  editProduct(name,category,description,id){
    const product = {
      name: name,
      category: category,
      description: description
    };
    return this.http.put(this.baseUrl+'/'+id, product);
  
  }
  deleteProduct(id){
    return this.http.delete(this.baseUrl+'/'+id);
  }

}
