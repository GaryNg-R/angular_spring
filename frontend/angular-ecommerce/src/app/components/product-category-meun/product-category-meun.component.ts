import { ProductService } from './../../services/product.service';
import { Component, OnInit } from '@angular/core';
import {ProductCategory} from 'src/app/common/product-category';

@Component({
  selector: 'app-product-category-meun',
  templateUrl: './product-category-meun.component.html',
  styleUrls: ['./product-category-meun.component.css']
})
export class ProductCategoryMeunComponent implements OnInit {

  productCategories: ProductCategory[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.listProductCategories();
  }


  listProductCategories() {
    this.productService.getProductCategories().subscribe(
      data => {
        console.log('Product Categories' +JSON.stringify(data));
        this.productCategories = data;
      }
    )
  }

}
