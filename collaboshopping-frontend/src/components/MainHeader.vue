<!-- MainHeader.vue -->


<script>
import '../plugins/vuetify.js'
import '../plugins/webfontloader.js'
import api from "@/plugins/axios.js";
import {TOKEN_KEY} from "../../common/variable.js";
import router from "@/router/index.js";

export default {
  data () {
    return {
      tab: null,
      items: [
        'web', 'shopping', 'videos', 'images', 'news',
      ],
      text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
      showLoginButton: true,
      showLogoutButton: true
    }
  },mounted() {
    this.loadFn();
  },methods: {
      loadFn() {
        let loginYn = localStorage.getItem(TOKEN_KEY);
        if (!((!loginYn && typeof loginYn === 'object'))) {
          /*data.showLoginButton = false;
          data.showLogoutButton = true;*/
        }
        else{
          /*data.showLoginButton = true;
          data.showLogoutButton = false;*/
        }
      },
      loginPage()
      {
        api.get("/member", {}).then((res) => {
          console.log("---axios Get 성공---- ");
          this.data = res.data;
          console.log(res.data);
        }).catch((res) => {
          console.error(res);
        });
      },
      removeLocalStorage()
      {
        localStorage.removeItem(TOKEN_KEY); // 키에 해당되는 데이터 삭제
      },
    }

}
</script>

<style scoped>

</style>

<template>
  <v-card>
    <v-toolbar color="warning">

      <v-btn @click="$router.push('/')">
        <v-toolbar-title>콜라보쇼핑</v-toolbar-title>
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
      <v-btn icon @click="$router.push('/login')" v-if="showLoginButton">
        <v-icon>mdi-login</v-icon>
      </v-btn>
      <v-btn icon @click="removeLocalStorage()" v-if="showLogoutButton">
        <v-icon>mdi-logout</v-icon>
      </v-btn>


      <template v-slot:extension>

        <v-tabs
            v-model="tab"
            align-tabs="title"
        >
          <div>
            <v-app-bar-nav-icon></v-app-bar-nav-icon>카테고리
          </div>
          <v-tab
              v-for="item in items"
              :key="item"
              :value="item"
          >
            {{ item }}
          </v-tab>
        </v-tabs>
      </template>
    </v-toolbar>

    <v-window v-model="tab">
      <v-window-item
          v-for="item in items"
          :key="item"
          :value="item"
      >
<!--        <v-card flat>
          <v-card-text v-text="text"></v-card-text>
        </v-card>-->
      </v-window-item>
    </v-window>
  </v-card>
  <hr/>
</template>