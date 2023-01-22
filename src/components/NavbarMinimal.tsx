import { useState } from 'react';
import { Navbar, Center, Tooltip, UnstyledButton, createStyles, Stack ,Image} from '@mantine/core';
import {
  TablerIcon,
  IconLogout,
  IconSwitchHorizontal,
  IconReportMoney,
  IconListCheck,
  IconChartBar,
  IconHelp,
} from '@tabler/icons';
import { MantineLogo } from '@mantine/ds';
import { useNavigate } from 'react-router-dom';

const useStyles = createStyles((theme) => ({
  link: {
    width: 50,
    height: 50,
    borderRadius: theme.radius.md,
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    color: theme.colorScheme === 'dark' ? theme.colors.dark[0] : theme.colors.gray[7],

    '&:hover': {
      backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[5] : theme.colors.gray[0],
    },
  },

  active: {
    '&, &:hover': {
      backgroundColor: theme.fn.variant({ variant: 'light', color: theme.primaryColor }).background,
      color: theme.fn.variant({ variant: 'light', color: theme.primaryColor }).color,
    },
  },
}));

interface NavbarLinkProps {
  icon: TablerIcon;
  label: string;
  active?: boolean;
  onClick?(): void;
}

function NavbarLink({ icon: Icon, label, active, onClick }: NavbarLinkProps) {
  const { classes, cx } = useStyles();
  return (
    <Tooltip label={label} position="right" transitionDuration={0}>
      <UnstyledButton onClick={onClick} className={cx(classes.link, { [classes.active]: active })}>
        <Icon stroke={1.5} />
      </UnstyledButton>
    </Tooltip>
  );
}

const mockdata = [
  { icon: IconReportMoney, label: 'Financial Records' , link: "/financial"},
  { icon: IconChartBar, label: 'Statistical Analysis', link: "/" },
  { icon: IconHelp, label: 'Tips', link: "/tips"},
];

export function NavbarMinimal() {
  const [active, setActive] = useState(2);
const navigate = useNavigate();

  const links = mockdata.map((link, index) => (
    <NavbarLink
      {...link}
      key={link.label}
      active={index === active}
      onClick={() => {navigate(mockdata[index].link);setActive(index); }}
    />
  ));

  return (
    <Navbar height={750} width={{ base: 80 }} p="md">
      <Center>
      <Image src = "https://cdn-icons-png.flaticon.com/512/2043/2043847.png" />     </Center>
      <Navbar.Section grow mt={50}>
        <Stack justify="center" spacing={0}>
          {links}
        </Stack>
      </Navbar.Section>
      <Navbar.Section>
        <Stack justify="center" spacing={0}>
          <NavbarLink icon={IconSwitchHorizontal} label="Change account" />
          <NavbarLink icon={IconLogout} label="Logout" />
        </Stack>
      </Navbar.Section>
    </Navbar>
  );
}