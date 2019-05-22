import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Product } from '../_models/product';

@Injectable({ providedIn: 'root' })
export class ProductService {
    constructor(private http: HttpClient) { }

    getProducts(){
        return this.http.get<Product[]>(`${environment.prodUrl}/products/`);
    }

    addProduct(product: Product) {
        console.log(product);
        return this.http.post(`${environment.prodUrl}/products/`, product);
    }

    updateProduct(product: Product) {
        console.log(product);
        return this.http.put(`${environment.prodUrl}/products/`, product);
    }

    deleteProduct(id: string) {
        console.log(id);
        return this.http.delete(`${environment.prodUrl}/products/${id}`);
    }
}