import { TestBed } from '@angular/core/testing';

import { RecipeTypeService } from './recipe-type.service';

describe('RecipeTypesService', () => {
  let service: RecipeTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecipeTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
