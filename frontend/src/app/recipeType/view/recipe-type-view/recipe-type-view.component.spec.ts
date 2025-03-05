import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeTypeViewComponent } from './recipe-type-view.component';

describe('RecipeTypeViewComponent', () => {
  let component: RecipeTypeViewComponent;
  let fixture: ComponentFixture<RecipeTypeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecipeTypeViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecipeTypeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
