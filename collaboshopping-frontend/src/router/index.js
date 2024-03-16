import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import HomeView from "@/views/HomeView.vue";
import Main from "@/views/Main.vue";

const routes = [
    {
        path: '/',       // 스프링으로 치면 킨트롤러부분같은 느낌이다.
        name: 'Main',
        component: Main
    },{
        path: '/login',
        name: 'Login',
        component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
    },{
        path: '/join',
        name: 'Join',
        component: () => import(/* webpackChunkName: "about" */ '../views/Join.vue')
    },{
        path: '/collaboratorRegister',
        name: 'CollaboratorRegister',
        component: () => import(/* webpackChunkName: "about" */ '../views/CollaboratorRegister.vue')
    },{
        path: '/about',
        name: 'About',
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    },{
        path: '/home',       // 스프링으로 치면 킨트롤러부분같은 느낌이다.
        name: 'HomeView',
        component: HomeView
    },{
        path: '/sample',       // 스프링으로 치면 킨트롤러부분같은 느낌이다.
        name: 'Sample',
        component: () => import(/* webpackChunkName: "about" */ '../views/Sample.vue')
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router