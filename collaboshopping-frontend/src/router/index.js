import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import HomeView from "@/views/HomeView.vue";

const routes = [
    {
        path: '/',       // 스프링으로 치면 킨트롤러부분같은 느낌이다.
        name: 'Home',
        component: Home
    },{
        path: '/login',
        name: 'Login',
        component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
    },{
        path: '/join',
        name: 'Join',
        component: () => import(/* webpackChunkName: "about" */ '../views/Join.vue')
    },{
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
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