<script setup>

</script>

<template>
  <div id="app">
    <v-app>
      <!-- 앱 바 색상을 primary로 설정하고 fixed로 위치 고정 -->
      <v-app-bar app color="primary" dark fixed>
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
        <v-toolbar-title>마스터 페이지</v-toolbar-title>
        <!-- 우측에 추가메뉴 아이콘을 넣기 위해 v-spacer 엘리먼트 사용 -->
        <v-spacer></v-spacer>
        <v-btn icon>
          <v-icon>mdi-dots-vertical</v-icon>
        </v-btn>
      </v-app-bar>

      <!-- v-main -->
      <v-main>
        <v-container>
          <h1 class="display-1 my-5">안녕하세요</h1>
          <p class="body-2 my-4">마스터 페이지 입니다.</p>
          <v-divider></v-divider>
          <h1 class="display-3 my-4">안녕하세요</h1>
          <p class="body-3 my-4">마스터 페이지 입니다.</p>
        </v-container>
      </v-main>

      <!-- footer 색상을 secondary로 설정하고 fixed로 위치 고정 -->
      <v-footer color="secondary" dark fixed>
        <div class="mx-auto">Copyright &copy;</div>
      </v-footer>
    </v-app>
  </div>
</template>

<style scoped>

</style>