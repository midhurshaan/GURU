import {
    ThemeIcon,
    Text,
    Title,
    Container,
    SimpleGrid,
    useMantineTheme,
    createStyles,
  } from '@mantine/core';
  import { IconGauge, IconCookie, IconUser, IconMessage2, IconLock, TablerIcon, IconCurrencyDollarOff, IconRefresh, IconListNumbers, IconBusinessplan } from '@tabler/icons';
  
  export const MOCKDATA = [
    {
      icon: IconListNumbers,
      title: 'Prioritize your Spending',
      description:
        'Decide which expenses are most important and mkae sure to budget them first',
    },
    {
      icon: IconBusinessplan,
      title: 'Track your Spending',
      description:
        'Every week, update all of your spendings on the website, including small purchases, to help you stay on budget',
    },
    {
      icon: IconCurrencyDollarOff,
      title: 'Live Below your Means',
      description:
        'Try to save as much money as possible and put it towards your long-term financial goals',
    },
    {
      icon: IconRefresh,
      title: 'Review your budget regularly',
      description:
        'Review your budget on a regular basis and make adjustments as needed to ensure that you are staying on track',
    },
    {
      icon: IconMessage2,
      title: 'Communicate with your partner',
      description:
        ' If you are married or have a partner, communicate with them about your budget and make sure you are on the same page.',
    },
  ];
  
  interface FeatureProps {
    icon: TablerIcon;
    title: React.ReactNode;
    description: React.ReactNode;
  }
  
  export function Feature({ icon: Icon, title, description }: FeatureProps) {
    const theme = useMantineTheme();
    return (
      <div>
        <ThemeIcon variant="light" size={40} radius={40}>
          <Icon size={20} stroke={1.5} />
        </ThemeIcon>
        <Text style={{ marginTop: theme.spacing.sm, marginBottom: 7 }}>{title}</Text>
        <Text size="sm" color="dimmed" style={{ lineHeight: 1.6 }}>
          {description}
        </Text>
      </div>
    );
  }
  
  const useStyles = createStyles((theme) => ({
    wrapper: {
      paddingTop: theme.spacing.xl * 4,
      paddingBottom: theme.spacing.xl * 4,
    },
  
    title: {
      fontFamily: `Greycliff CF, ${theme.fontFamily}`,
      fontWeight: 900,
      marginBottom: theme.spacing.md,
      textAlign: 'center',
  
      [theme.fn.smallerThan('sm')]: {
        fontSize: 28,
        textAlign: 'left',
      },
    },
  
    description: {
      textAlign: 'center',
  
      [theme.fn.smallerThan('sm')]: {
        textAlign: 'left',
      },
    },
  }));
  
  interface FeaturesGridProps {
    title: React.ReactNode;
    description: React.ReactNode;
    data?: FeatureProps[];
  }
  
  export function FeaturesGrid() {
    const { classes, theme } = useStyles();
    const features = MOCKDATA.map((feature, index) => <Feature {...feature} key={index} />);
  
    return (
      <Container className={classes.wrapper}>
        <Title className={classes.title}>Tips</Title>
  
        <Container size={560} p={0}>
          <Text size="sm" className={classes.description}>
            Top tier advice based on your profile
          </Text>
        </Container>
  
        <SimpleGrid
          mt={60}
          cols={3}
          spacing={theme.spacing.xl * 2}
          breakpoints={[
            { maxWidth: 980, cols: 2, spacing: 'xl' },
            { maxWidth: 755, cols: 1, spacing: 'xl' },
          ]}
        >
          {features}
        </SimpleGrid>
      </Container>
    );
  }