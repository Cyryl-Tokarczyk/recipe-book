import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeTypeListComponent } from './recipe-type-list.component';

describe('RecipeTypeListComponent', () => {
  let component: RecipeTypeListComponent;
  let fixture: ComponentFixture<RecipeTypeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecipeTypeListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecipeTypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
