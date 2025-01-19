package project.redis.infrastructure.common.config;

//@EnableCaching
//@Configuration
//public class LocalCacheConfig {
//
//    @Bean
//    public Caffeine<Object, Object> caffeineConfig() {
//        return Caffeine.newBuilder()
//                .expireAfterWrite(Duration.ofDays(1))
//                .initialCapacity(200)
//                .maximumSize(500)
//                .recordStats();
//    }
//
//
//    @Bean("localCacheManager")
//    public CacheManager localCacheManager() {
//        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
//        caffeineCacheManager.setCaffeine(caffeineConfig());
//        return caffeineCacheManager;
//    }
//}
