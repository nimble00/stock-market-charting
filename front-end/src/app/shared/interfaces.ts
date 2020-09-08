// import { ModuleWithProviders } from '@angular/core';
// import { Routes } from '@angular/router';

export interface MyUser {
    id: number;
    fullname: string;
    email: string;
    usertype: string;
    verified: boolean;
}



export interface IOrder {
    productName: string;
    itemCost: number;
}



export interface IPagedResults<T> {
    totalRecords: number;
    results: T;
}

export interface MyUserLogin {
    email: string;
    password: string;
}

export interface IApiResponse {
    status: boolean;
    error?: string;
}
