## AnnotationConfigApplicationContext(BeanDefinitionRegistry) context
* AnnotatedBeanDefinitionReader reader
* ClassPathBeanDefinitionScanner scanner
* DefaultListableBeanFactory beanFactory

## AnnotatedBeanDefinitionReader reader
* BeanDefinitionRegistry registry -> context
* BeanNameGenerator beanNameGenerator
* ScopeMetadataResolver scopeMetadataResolver
* ConditionEvaluator conditionEvaluator

## ClassPathBeanDefinitionScanner scanner
* BeanDefinitionRegistry registry -> context
* BeanDefinitionDefaults beanDefinitionDefaults
* BeanNameGenerator beanNameGenerator
* ScopeMetadataResolver scopeMetadataResolver

## DefaultListableBeanFactory(BeanDefinitionRegistry, ConfigurableListableBeanFactory) beanFactory
* Map<Class, Object> resolvableDependencies
* Map<Class, Object> allBeanNamesByType
* Map<Class, Object> singletonBeanNamesByType
* Map<String, BeanDefinition> beanDefinitionMap
* List<String> beanDefinitionNames
* Set<String> manualSingletonNames
* BeanFactory parentBeanFactory
* ClassLoader beanClassLoader
* Comparator< Object> dependencyComparator
* AutowireCandidateResolver autowireCandidateResolver
* BeanExpressionResolver beanExpressionResolver
* Set<PropertyEditorRegistrar> propertyEditorRegistrars
* List<BeanPostProcessor> beanPostProcessors
* Map<String, RootBeanDefinition> mergedBeanDefinitions
* Set<Class<?>> ignoredDependencyInterfaces
* Map<String, Object> singletonObjects

---

## AnnotationConfigApplicationContext context 初始化
* 其内部属性 DefaultListableBeanFactory beanFactory 初始化
* 其内部属性 AnnotatedBeanDefinitionReader reader 初始化
    * 其内部属性 BeanDefinitionRegistry registry 赋值, 即为context对象
    * 其内部属性 ConditionEvaluator conditionEvaluator 初始化
    * 得到registry中的属性beanFactory, 即为context属性:DefaultListableBeanFactory beanFactory
    * beanFactory属性设置:dependencyComparator -> AnnotationAwareOrderComparator
    * beanFactory属性设置:autowireCandidateResolver -> ContextAnnotationAutowireCandidateResolver
    * beanFactory registerPostProcessor(beanDefinitionMap) -> ConfigurationClassPostProcessor
    * beanFactory registerPostProcessor(beanDefinitionMap) -> AutowiredAnnotationBeanPostProcessor
    * beanFactory registerPostProcessor(beanDefinitionMap) -> CommonAnnotationBeanPostProcessor
    * beanFactory registerPostProcessor(beanDefinitionMap) -> (if jpaPresent) PersistenceAnnotationBeanPostProcessor
    * beanFactory registerPostProcessor(beanDefinitionMap) -> EventListenerMethodProcessor
    * beanFactory registerPostProcessor(beanDefinitionMap) -> DefaultEventListenerFactory
* 其内部属性 ClassPathBeanDefinitionScanner scanner 初始化

## AnnotationConfigApplicationContext register 调用
* 其内部属性 reader doRegisterBean
* 新建BeanDefinition,设置默认属性 -> AnnotatedGenericBeanDefinition
* beanFactory registerPostProcessor(beanDefinitionMap) -> AnnotatedGenericBeanDefinition

## AnnotationConfigApplicationContext refresh 调用
* 得到属性beanFactory
* beanFactory属性设置:beanClassLoader -> AppClassLoader
* beanFactory属性设置:beanExpressionResolver -> StandardBeanExpressionResolver
* beanFactory属性添加:propertyEditorRegistrars -> ResourceEditorRegistrar
* beanFactory属性添加:beanPostProcessors -> ApplicationContextAwareProcessor
* beanFactory属性添加:ignoredDependencyInterfaces -> EnvironmentAware,EmbeddedValueResolverAware,ResourceLoaderAware,ApplicationEventPublisherAware,,MessageSourceAware,ApplicationContextAware
* beanFactory属性添加:resolvableDependencies -> BeanFactory,ResourceLoader,ApplicationEventPublisher,ApplicationContext
* beanFactory属性添加:beanPostProcessors -> ApplicationListenerDetector
* beanFactory属性添加:singletonObjects -> "environment", "systemProperties", "systemEnvironment"

* 