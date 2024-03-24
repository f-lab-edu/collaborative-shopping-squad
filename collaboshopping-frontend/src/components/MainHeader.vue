<!-- MainHeader.vue -->


<script>
import {TOKEN_KEY} from "../../common/variable.js";
import {defineComponent} from "vue";

export default defineComponent({
  methods: {
    TOKEN_KEY() {
      return TOKEN_KEY
    },
    logout(){
      localStorage.removeItem(TOKEN_KEY)
      location.reload();
    }
  }
})




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
      <v-btn icon @click="$router.push('/login')">
        <v-icon>mdi-login</v-icon>
      </v-btn>
      <v-btn icon @click="logout()">
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