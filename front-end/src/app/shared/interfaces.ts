// import { ModuleWithProviders } from '@angular/core';
// import { Routes } from '@angular/router';

export interface MyUser {
    id: number;
    fullname: string;
    email: string;
    usertype: string;
    confirmed: boolean;
}



export interface Company {
    id: string;
    name: string;
    turnover: number;
    ceo: "daddy musk";
    boardOfDirs: any;
    stockExchangeList: any;
    sector: string;
    briefWriteup: string;
    tickerList: any;
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
