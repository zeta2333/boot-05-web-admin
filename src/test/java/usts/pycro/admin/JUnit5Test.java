package usts.pycro.admin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-09 6:52 PM
 */


@DisplayName("JUnit5测试类")
/*
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 */
//@SpringBootTest
public class JUnit5Test {

    //@Autowired
    JdbcTemplate jdbcTemplate;


    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testParameterized(int i) {
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("参数化测试")
    @MethodSource("getStrings")
    public void testParameterized2(String s) {
        System.out.println(s);
    }

    static Stream<String> getStrings() {
        return Stream.of("abc", "def", "ghi");
    }

    @Nested
    class nestedTest {
        @Test
        public void testNest() {
            assertTrue(true);
        }
    }

    /**
     * 测试前置条件（假设）
     */
    @Test
    @DisplayName("测试前置条件")
    public void testAssumptions() {
        Assumptions.assumeTrue(
                () -> Math.random() > 0.999999999,
                "假设失败"
        );
        System.out.println("假设成功");
    }

    @Test
    @DisplayName("direct fail")
    public void testFail() {
        if (1 % 2 == 0)
            fail("直接失败");
    }

    @Test
    @DisplayName("timeout assertion")
    public void testTimeoutAssert() {
        // 断言程序不会超时
        assertTimeout(
                Duration.ofMillis(1000),
                () -> Thread.sleep(1001),
                "业务逻辑超时"
        );
    }

    @Test
    @DisplayName("exception assertion")
    public void testException() {
        // 断定业务逻辑一定出现异常
        assertThrows(
                ArithmeticException.class,
                () -> {
                    int i = 1;
                },
                "业务逻辑居然正常执行？"
        );
    }

    @Test
    @DisplayName("assert all")
    public void testAssertAll() {
        assertAll("test",
                () -> assertTrue(true && false, "结果不为true"),
                () -> assertEquals(6, add(2, 3), "结果不是预期的"),
                () -> System.out.println(1)
        );
    }

    @Test
    @DisplayName("array assertion")
    public void testArrayAssertion() {
        assertArrayEquals(new int[]{2, 1}, new int[]{1, 2});
    }

    @Test
    @DisplayName("simple assertion")
    public void testSimpleAssertions() {
        int res = add(3, 4);
        assertEquals(7, res, "业务逻辑计算错误");
        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1, o2, "两个对象不一样");
    }

    int add(int a, int b) {
        return a + b;
    }

    @DisplayName("测试方法1") //为测试类或测试方法设置展示名称
    @Test
    public void test1() {
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Disabled //禁用掉该测试方法，即在测试所有方法时忽略该方法的执行
    @DisplayName("测试方法2") //为测试类或测试方法设置展示名称
    @Test
    public void test2() {
        System.out.println(2);
    }

    /**
     * 设置超时时间，超出给定时间会抛出异常
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeout() throws InterruptedException {
        Thread.sleep(501);
    }

    @RepeatedTest(value = 5)
    @DisplayName("重复测试")
    public void testRepeat() {
        System.out.println("repeat");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("测试开始...");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("测试结束...");
    }

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("所有测试开始...");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("所有测试结束...");
    }
}
