package tech.jlsol.servernamedcbot.features;

import java.awt.*;
import java.sql.SQLException;
import java.util.Objects;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.util.Config;
import tech.jlsol.servernamedcbot.util.SQLHandler;

public class TicketListener extends ListenerAdapter {

  public void onPrivateMessageReceived(
    @Nonnull PrivateMessageReceivedEvent event
  ) {
    if (!event.getAuthor().isBot()) {
      try {
        SQLHandler.MySQLUseDataManager.setTicket(
          event.getAuthor().getAsTag(),
          "created",
          "NULL",
          event.getMessage().getContentDisplay()
        );
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      } //Create Ticket in database
      try {
        Objects
          .requireNonNull(
            event
              .getJDA()
              .getGuildById(Config.readConfig("data", "settings", "guildID"))
          )
          .getTextChannelsByName(
            Config.readConfig("data", "settings", "ticketChannel"),
            true
          )
          .get(0)
          .sendMessage(
            getMessage(
              "New Ticket: " + SQLHandler.MySQLUseDataManager.getTicketIdMax(),
              SQLHandler.MySQLUseDataManager
                .getTicket(SQLHandler.MySQLUseDataManager.getTicketIdMax())
                .get(1)
                .toString(),
              Color.BLUE,
              SQLHandler.MySQLUseDataManager
                .getTicket(SQLHandler.MySQLUseDataManager.getTicketIdMax())
                .get(4)
                .toString(),
              "Status: " +
              SQLHandler.MySQLUseDataManager
                .getTicket(SQLHandler.MySQLUseDataManager.getTicketIdMax())
                .get(2)
                .toString()
            )
          )
          .queue();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } // Send message in channel
    }
  }

  public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
    if (
      event
        .getChannel()
        .getName()
        .equals(Config.readConfig("data", "settings", "ticketChannel")) &&
      event.getMessage().getAuthor().isBot() &&
      (event.getMessage().getContentDisplay().equals(""))
    ) {
      event
        .getChannel()
        .addReactionById(event.getMessageId(), "U+2705") //green checkmark -- done
        .queue();
      event
        .getChannel()
        .addReactionById(event.getMessageId(), "U+274C") //red_cross -- closed
        .queue();
      event
        .getChannel()
        .addReactionById(event.getMessageId(), "U+2611") //blue checkmark -- in work
        .queue();
      try {
        SQLHandler.MySQLUseDataManager.setTicketHelper(
          SQLHandler.MySQLUseDataManager.getTicketIdMax(),
          Objects
            .requireNonNull(
              event
                .getJDA()
                .getGuildById(Config.readConfig("data", "settings", "guildID"))
            )
            .getTextChannelsByName(
              Config.readConfig("data", "settings", "ticketChannel"),
              true
            )
            .get(0)
            .getLatestMessageId()
        );
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }

  public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
    if (
      event
        .getReaction()
        .getChannel()
        .getName()
        .equals(Config.readConfig("data", "settings", "ticketChannel"))
    ) {
      if (
        event
          .getReaction()
          .getReactionEmote()
          .toString()
          .substring(3)
          .equals("U+274c")
      ) {
        try {
          SQLHandler.MySQLUseDataManager.updateTicket(
            "closed",
            Objects.requireNonNull(event.getUser()).getAsTag(),
            SQLHandler.MySQLUseDataManager.getTicketHelper(event.getMessageId())
          );
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      if (
        event
          .getReaction()
          .getReactionEmote()
          .toString()
          .substring(3)
          .equals("U+2611")
      ) {
        try {
          SQLHandler.MySQLUseDataManager.updateTicket(
            "in progress",
            Objects.requireNonNull(event.getUser()).getAsTag(),
            SQLHandler.MySQLUseDataManager.getTicketHelper(event.getMessageId())
          );
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      if (
        event
          .getReaction()
          .getReactionEmote()
          .toString()
          .substring(3)
          .equals("U+2705")
      ) {
        try {
          SQLHandler.MySQLUseDataManager.updateTicket(
            "done",
            Objects.requireNonNull(event.getUser()).getAsTag(),
            SQLHandler.MySQLUseDataManager.getTicketHelper(event.getMessageId())
          );
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
    }
    if (!Objects.requireNonNull(event.getUser()).isBot()) {
      try {
        switch (
          SQLHandler.MySQLUseDataManager
            .getTicket(SQLHandler.MySQLUseDataManager.getTicketIdMax())
            .get(2)
            .toString()
        ) {
          case "closed":
            try {
              Objects
                .requireNonNull(
                  event
                    .getJDA()
                    .getGuildById(
                      Config.readConfig("data", "settings", "guildID")
                    )
                )
                .getTextChannelsByName(
                  Config.readConfig("data", "settings", "ticketChannel"),
                  true
                )
                .get(0)
                .editMessageById(
                  event.getMessageId(),
                  getMessage(
                    "New Ticket: " +
                    SQLHandler.MySQLUseDataManager.getTicketIdMax(),
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(1)
                      .toString(),
                    Color.RED,
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(4)
                      .toString(),
                    "Status: " +
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(2)
                      .toString()
                  )
                )
                .queue();
            } catch (SQLException throwables) {
              throwables.printStackTrace();
            }
            break;
          case "in progress":
            try {
              Objects
                .requireNonNull(
                  event
                    .getJDA()
                    .getGuildById(
                      Config.readConfig("data", "settings", "guildID")
                    )
                )
                .getTextChannelsByName(
                  Config.readConfig("data", "settings", "ticketChannel"),
                  true
                )
                .get(0)
                .editMessageById(
                  event.getMessageId(),
                  getMessage(
                    "New Ticket: " +
                    SQLHandler.MySQLUseDataManager.getTicketIdMax(),
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(1)
                      .toString(),
                    Color.ORANGE,
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(4)
                      .toString(),
                    "Status: " +
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(2)
                      .toString()
                  )
                )
                .queue();
            } catch (SQLException throwables) {
              throwables.printStackTrace();
            }
            break;
          case "done":
            try {
              Objects
                .requireNonNull(
                  event
                    .getJDA()
                    .getGuildById(
                      Config.readConfig("data", "settings", "guildID")
                    )
                )
                .getTextChannelsByName(
                  Config.readConfig("data", "settings", "ticketChannel"),
                  true
                )
                .get(0)
                .editMessageById(
                  event.getMessageId(),
                  getMessage(
                    "New Ticket: " +
                    SQLHandler.MySQLUseDataManager.getTicketIdMax(),
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(1)
                      .toString(),
                    Color.GREEN,
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(4)
                      .toString(),
                    "Status: " +
                    SQLHandler.MySQLUseDataManager
                      .getTicket(
                        SQLHandler.MySQLUseDataManager.getTicketIdMax()
                      )
                      .get(2)
                      .toString()
                  )
                )
                .queue();
            } catch (SQLException throwables) {
              throwables.printStackTrace();
            }
            break;
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }

  public MessageEmbed getMessage(
    String title,
    String author,
    Color color,
    String description,
    String status
  ) {
    return new EmbedBuilder()
      .setTitle(title)
      .setAuthor(author)
      .setColor(color)
      .setDescription(description)
      .setFooter(status)
      .build();
  }
}
