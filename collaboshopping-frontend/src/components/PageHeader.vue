<!-- PageHeader.vue -->
<template>
  <header> <!-- 헤더부분  -->
    <div id="nav">
      <router-link to="/">Home</router-link> |   <!-- 링크  router-link -->
      <router-link to="/about">About</router-link> |
      <router-link to="/board/list">게시판</router-link>
    </div>
  </header>
  <hr/>
</template>

<script>
export default {

}
</script>

<style scoped>

</style>