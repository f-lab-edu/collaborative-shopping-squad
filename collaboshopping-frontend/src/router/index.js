import { createRouter, createWebHistory } from 'vue-router'
import PageHome from '@/views/PageHome.vue'

const routes = [
    {
        path: '/',       // 스프링으로 치면 킨트롤러부분같은 느낌이다.
        name: 'PageHome',
        component: PageHome
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/PageAbout.vue')
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router