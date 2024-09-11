<template>
  <div class="container shopping-cart">
    <div class="content">
      <div class="row">
        <div class="col-md-12 col-lg-12" v-for='(item, index) in products' :key='index'>
          <div class="items">
            <div class="product">
              <div class="row">
                <div class="col-md-3">
                  <img class="img-fluid mx-auto d-block image" :src="getImageUrl(item.image)">
                </div>
                <div class="col-md-6">
                  <div class="info">
                    <div class="row">
                      <div class="col-md-5 product-name">
                        <div class="product-name">
                          <a class="product-name" v-bind:href="'/detail/' + item.id">{{ item.name }}</a>
                          <div class="product-info">
                            <div class="product-info-detail">{{ item.description }}</div>
                            <div class="product-info-detail">Seller: <a class="value" v-bind:href="item.seller.id">{{
                                item.seller.name
                              }}</a>
                            </div>
                            <div class="product-info-detail"><span v-if="item.freeDelivery"> FREE </span>Delivery: <span
                                class="value">{{ item.deliveryIn }}</span></div>
                            <div class="product-info-detail"><span class="value" v-html="item.features"></span></div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-3">
                  <div class="row info">
                    <div class="col-md-6 quantity">
                      <label for="quantity">Quantity:</label>
                      <input id="quantity" type="number" value="1" class="form-control quantity-input">
                    </div>
                    <div class="col-md-6 price">
                      <span>{{ item.money }} {{ item.price }}  {{ item.moneySymbol }}</span>
                    </div>
                  </div>
                </div>
                <div class="col-md-8"></div>
                <div class="col-md-4">
                  <div class=""></div>
                  <div class="row align-items-end">
                    <div class="col-md-6">
                      <button class="btn btn-primary">Add to Basket</button>
                    </div>
                    <div class="col-md-6">
                      <button class="btn btn-success">Buy now</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
