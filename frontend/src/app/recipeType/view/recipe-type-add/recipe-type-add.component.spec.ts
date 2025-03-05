import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeTypeAddComponent } from './recipe-type-add.component';

describe('RecipeTypeAddComponent', () => {
  let component: RecipeTypeAddComponent;
  let fixture: ComponentFixture<RecipeTypeAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecipeTypeAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecipeTypeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
