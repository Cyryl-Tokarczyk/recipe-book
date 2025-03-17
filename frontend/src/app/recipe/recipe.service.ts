import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recipes } from './model/recipes';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private readonly apiAddress: string = `/api/recipes`

  constructor(private httpClient: HttpClient) { }

  getRecipesByType(typeUuid: string): Observable<Recipes> {
    return this.httpClient.get<Recipes>(`${this.apiAddress}/type/${typeUuid}`)
  }

}
