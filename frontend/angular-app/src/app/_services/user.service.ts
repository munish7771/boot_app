import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { User } from '../_models/user';
import { Product } from '../_models/product';
import { Register } from '../_models/register';

@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/users/`);
    }

    getProducts(){
        return this.http.get<Product[]>(`${environment.apiUrl}/users/Products/`);
    }

    register(register: Register) {
        console.log(register);
        return this.http.post(`${environment.apiUrl}/api/auth/signup`, register);
    }

    updateUser(user: User) {
        user.role = "1";
        console.log("before put: " + JSON.stringify(user))
        return this.http.put(`${environment.apiUrl}/users/`, user);
    }

    deleteUser(username: string) {
        return this.http.delete(`${environment.apiUrl}/users/${username}`);
    }
}