import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductCategoryMeunComponent } from './product-category-meun.component';

describe('ProductCategoryMeunComponent', () => {
  let component: ProductCategoryMeunComponent;
  let fixture: ComponentFixture<ProductCategoryMeunComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductCategoryMeunComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductCategoryMeunComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
