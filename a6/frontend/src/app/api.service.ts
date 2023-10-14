import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Todo } from './types';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private apiURL = 'http://127.0.0.1:8080';

  constructor(private http: HttpClient) {}

  getTodos(): Observable<Todo[]> {
    return this.http.get<Todo[]>(`${this.apiURL}/todos`);
  }

  getTodo(id: number): Observable<Todo> {
    return this.http.get<Todo>(`${this.apiURL}/todos/${id}`);
  }

  postTodo(todo: Todo): Observable<Todo> {
    return this.http.post<Todo>(`${this.apiURL}/todos`, todo);
  }

  updateTodo(newTodo: Todo, id: number) {
    newTodo.id = id;
    this.http.put(`${this.apiURL}/todos/${id}`, newTodo);
  }

  deleteTodo(id: number): Observable<Todo> {
    return this.http.delete<Todo>(`${this.apiURL}/todos/${id}`);
  }
}
