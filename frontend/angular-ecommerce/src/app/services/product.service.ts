import { ProductCategory } from './../common/product-category';
import { NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/products'

  private categoryUrl = 'http://localhost:8080/api/product-category'

  constructor(private httpClient: HttpClient) { }

  getProductList(theCategeoryId: number): Observable<Product[]>{

    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategeoryId}`;

    return this.getProducts(searchUrl);
  }

  getProductListPaginate(thePage:number, thePageSize: number, theCategeoryId: number): Observable<GetResponseProducts>{

    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategeoryId}&page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<GetResponseProducts>(searchUrl);
  }


  searchProducts(theKeywoard: string): Observable<Product[]>{
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${theKeywoard}`;

    return this.getProducts(searchUrl);
  }

  getProductCategories(): Observable<ProductCategory[]>{
    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.productCategory)
    );
  
  }

  private getProducts(searchUrl: string): Observable<Product[]> {
    return this.httpClient.get<GetResponseProducts>(searchUrl).pipe(
      map(response => response._embedded.products)
    );
  }

  getProduct(theProductId: number) : Observable<Product> {
    // need to build URL based on product id 
    const productUrl = `${this.baseUrl}/${theProductId}`
    return this.httpClient.get<Product>(productUrl);
  }

}


  interface GetResponseProducts {
    _embedded:{
      products: Product[];
    },
    page:{
      size: number,
      totalElements: number,
      totalPages: number,
      number : number
    }
  }

  interface GetResponseProductCategory {
    _embedded:{
      productCategory: ProductCategory[];
    }
  }

