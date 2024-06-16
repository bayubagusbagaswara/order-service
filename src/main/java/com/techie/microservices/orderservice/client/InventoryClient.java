package com.techie.microservices.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "inventory", url = "http://localhost:8082")
public class InventoryClient {
}
