package dao;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:META-INF/spring/datasource_test.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
//@Transactional
public class QuizDaoTest {
//
//	private static Logger logger = LoggerFactory.getLogger(QuizDaoTest.class);
//
//	private static ApplicationContext applicationContext;
//	//private static Mockery context;
//
//	@Autowired
//	private static QuizDao quizDao;
//	
//	private static Quiz quiz;
//	
//	@BeforeClass
//	@Transactional(readOnly=false)
//	public static void setUpOnce() throws Exception {
//		try {
//			// Create & register a listener with spring.
//			applicationContext = new ClassPathXmlApplicationContext(new String[] { "META-INF/spring/datasource_test.xml" });
//			
//			quizDao = applicationContext.getBean(QuizDao.class);
//			
//			quiz = new Quiz();
//			quiz.setName("Test");
//			
//			quiz = quizDao.create(quiz);
//			
//			quizDao.commit();
//			// Now set the mock
//			//context = new JUnit4Mockery();
//		} catch (Exception e) {
//			logger.error(e.getLocalizedMessage());
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	@Rollback(false)
//	public void testCreate() {
////		Quiz quiz = new Quiz();
////		quiz.setName("Test");
////		
////		quiz = quizDao.create(quiz);
//		
//		System.err.println(quiz.getId());
//		Quiz dbQuiz = quizDao.get(Quiz.class, quiz.getId());
//		
//		System.err.println(dbQuiz.getName());
//	}
}
