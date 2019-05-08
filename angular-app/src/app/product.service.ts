import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  baseUrl='http://localhost:9008/products'

  constructor(public http:HttpClient) { }

  listAllProducts() {
    return this.http.get(this.baseUrl+'/');
  }

  addproduct(name, category,description) {
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

  deleteUser(id){
    return this.http.delete(this.baseUrl+'/'+id);
  }
}
