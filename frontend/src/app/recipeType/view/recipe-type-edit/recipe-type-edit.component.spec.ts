import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeTypeEditComponent } from './recipe-type-edit.component';

describe('RecipeTypeEditComponent', () => {
  let component: RecipeTypeEditComponent;
  let fixture: ComponentFixture<RecipeTypeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecipeTypeEditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecipeTypeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
