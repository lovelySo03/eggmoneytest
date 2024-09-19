<script setup lang="ts">
import { RouterLink, RouterView, useRoute, useRouter } from "vue-router"
import NavBar from "./components/navbar/NavBar.vue"
import NavBarTop from "./components/navbar/NavBarTop.vue"
import { useVariableStore } from "./stores/variable"
import { computed } from "vue"
</script>

<template>
  <div class="flex justify-center bg-gray-800">
    <div class="main-container bg-gray-200">
      <NavBarTop />
      <RouterView class="mt-14 mb-16" />
      <p>하이</p>
      <NavBar />
    </div>
  </div>
</template>

<style sc>
.main-container {
  width: 100%;
  height: 100%;
  min-height: 100vh;
}

@media (min-width: 393px) {
  .main-container {
    max-width: 393px;
  }
}
</style>
