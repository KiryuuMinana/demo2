/**
 * Copyright (C) 2020-2025, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoyfriendAcceptabilityGame {

	private static final String[] OPTIONS = {"夜店", "冷暴力", "哭穷", "纹身", "狐臭", "脚臭", "口臭", "看擦边视频", "束脚裤", "打乳钉", "兜不住屎","脚踏两只船"};
	private int index = 0;
	private String finalChoice = "";

	public BoyfriendAcceptabilityGame() {
		// 创建主窗口
		JFrame frame = new JFrame("你最接受不了男朋友什么？");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// 创建提问文本
		JLabel questionLabel = new JLabel("你最接受不了男朋友什么？", SwingConstants.CENTER);
		questionLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		frame.add(questionLabel, BorderLayout.NORTH);

		// 按钮面板
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2, 20, 0));
		frame.add(buttonPanel, BorderLayout.CENTER);

		// 左右按钮
		JButton leftButton = new JButton("抽烟");
		JButton rightButton = new JButton("喝酒");

		// 设置按钮字体
		leftButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		rightButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));

		buttonPanel.add(leftButton);
		buttonPanel.add(rightButton);

		// 按钮点击事件
		leftButton.addActionListener(e -> handleClick(leftButton, rightButton));
		rightButton.addActionListener(e -> handleClick(rightButton, leftButton));

		// 显示窗口
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void handleClick(JButton clickedButton, JButton otherButton) {
		// 动画效果：按钮放大再缩小
		animateButton(clickedButton);

		// 保存选择
		finalChoice = clickedButton.getText();

		// 更新另一个按钮的内容
		if (index < OPTIONS.length) {
			otherButton.setText(OPTIONS[index]);
			index++;
		} else {
			// 游戏结束
			JOptionPane.showMessageDialog(null, "你最接受不了男朋友的事情是：" + finalChoice, "游戏结束", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	private void animateButton(JButton button) {
		Timer timer = new Timer(10, null);
		timer.addActionListener(new ActionListener() {
			private int step = 0;
			private boolean expanding = true;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (expanding) {
					button.setFont(button.getFont().deriveFont(button.getFont().getSize() + 1f));
					step++;
					if (step == 5) {
						expanding = false;
					}
				} else {
					button.setFont(button.getFont().deriveFont(button.getFont().getSize() - 1f));
					step--;
					if (step == 0) {
						timer.stop();
					}
				}
			}
		});
		timer.start();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(BoyfriendAcceptabilityGame::new);
	}
}
