import { createStyles, Progress, Box, Text, Group, Paper, SimpleGrid, Card } from '@mantine/core';
import { IconArrowUpRight, IconDeviceAnalytics } from '@tabler/icons';

const useStyles = createStyles((theme) => ({
  progressLabel: {
    fontFamily: `Greycliff CF, ${theme.fontFamily}`,
    lineHeight: 1,
    fontSize: theme.fontSizes.sm,
  },

  stat: {
    borderBottom: '3px solid',
    paddingBottom: 5,
  },

  statCount: {
    fontFamily: `Greycliff CF, ${theme.fontFamily}`,
    lineHeight: 1.3,
  },

  diff: {
    fontFamily: `Greycliff CF, ${theme.fontFamily}`,
    display: 'flex',
    alignItems: 'center',
  },

  icon: {
    color: theme.colorScheme === 'dark' ? theme.colors.dark[3] : theme.colors.gray[4],
  },
}));

interface StatsSegmentsProps {
  amount: string;
  name: string;
  percent: number;
}

export function StatsSegments({ amount, name, percent }: StatsSegmentsProps) {
   return <Card
    withBorder
    radius="md"
    p="xl"
    sx={(theme) => ({
      backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[7] : theme.white,
    })}
  >
    <Text size="xs" transform="uppercase" weight={700} color="dimmed">
      {name}
    </Text>
    <Text size="lg" weight={500}>
      {amount}
    </Text>
    <Progress value={percent} mt="md" size="lg" radius="xl" />
  </Card>
}