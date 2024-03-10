import {fileURLToPath, URL} from 'node:url'

import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vite-plugin
import vuetify from 'vite-plugin-vuetify'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        vuetify({ autoImport: true }),
    ],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url))
        }
    },
    server: {
        proxy: {
            "/api/v1": {
                target: 'http://localhost:8080',
                changeOrigin: true,
                //rewrite: (path) => path.replace(/^\/api/, ""),
                secure: false,
                ws: true
            }
        }

    }})
