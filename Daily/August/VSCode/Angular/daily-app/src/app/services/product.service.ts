import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private url = 'app/product.json';

  constructor(private http: HttpClient) {}

  getListofProduct(): Observable<Product> {
    return this.http
      .get(this.url)
      .map((response: Response) => <Product>response.json())
      .do((data) => console.log(JSON.stringify(data)));
  }
}
